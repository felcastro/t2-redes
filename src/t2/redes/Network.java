package t2.redes;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Network {

    private String networkIp;
    private String sysDescrOid;
    private int minIpRange;
    private int maxIpRange;
    public ArrayList<Agent> agents;
    public ArrayList<String> notAddedIps;
    public ArrayList<String> addedIps;

    public Network() {
        this.minIpRange = 0;
        this.maxIpRange = 255;
        addedIps = new ArrayList();
        notAddedIps = new ArrayList();
        this.networkIp = getNetworkAddress();
        this.sysDescrOid = ".1.3.6.1.2.1.1.1.0";
        agents = getAllAgents();
    }

    public ArrayList<Agent> getAllAgents() {
        ArrayList<Agent> agents = new ArrayList();
        for (int i = minIpRange; i <= maxIpRange; i++) {
            Agent agent = new Agent(networkIp + i);
            if (agent.getAgentInfo(sysDescrOid) != null) {
                agents.add(new Agent(networkIp + i));
                addedIps.add(String.valueOf(i));
            }
            notAddedIps.add(String.valueOf(i));
        }
        System.out.println("Added IP's \n" + addedIps.toString());
        System.out.println("Not added IP's \n" + notAddedIps.toString());
        return agents;
    }

    private String getNetworkAddress() {
        try {
            networkIp = InetAddress.getLocalHost().getHostAddress();
            networkIp = networkIp.substring(0, networkIp.lastIndexOf(".") + 1);
            return networkIp;
        } catch (UnknownHostException ex) {
            return null;
        }
    }
    
    public Agent getAgentByIp(String ip) {
        return agents.stream()
                .filter((agent) -> agent.ipAddress.equals(ip))
                .findFirst()
                .orElse(null);
    }
}
