package t2.redes;

import java.io.IOException;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class Agent {

    private String community;
    private int snmpVersion;
    private String port;
    public String ipAddress;

    public Agent(String ipAddress) {
        this.ipAddress = ipAddress;
        this.community = "public";
        this.snmpVersion = SnmpConstants.version2c;
        this.port = "161";
    }

    public String getAgentInfo(String oidValue) {
        try {
            TransportMapping transport = new DefaultUdpTransportMapping();
            transport.listen();

            CommunityTarget comtarget = new CommunityTarget();
            comtarget.setCommunity(new OctetString(community));
            comtarget.setVersion(snmpVersion);
            comtarget.setAddress(new UdpAddress(ipAddress + "/" + port));
            comtarget.setRetries(0);
            comtarget.setTimeout(30);

            PDU pdu = new PDU();
            pdu.add(new VariableBinding(new OID(oidValue)));
            pdu.setType(PDU.GET);
            pdu.setRequestID(new Integer32(1));

            Snmp snmp = new Snmp(transport);

            ResponseEvent response = snmp.get(pdu, comtarget);

            if (response != null) {
                PDU responsePDU = response.getResponse();

                if (responsePDU != null) {
                    int errorStatus = responsePDU.getErrorStatus();

                    if (errorStatus == PDU.noError) {
                        String variableBindings = responsePDU.getVariableBindings().toString();
                        return variableBindings;
                    } else {
                        String errorStatusText = responsePDU.getErrorStatusText();
                        return errorStatusText;
                    }
                } else {
                    return null;
                }
            }
            snmp.close();
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
}
