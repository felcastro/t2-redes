package t2.redes;

public class Main {

//    private final String snmpInPktsOid = ".1.3.6.1.2.1.11.1";
//    private final String snmpOutPktsOid = ".1.3.6.1.2.1.11.2";
//    private final String tcpInSegsOid = ".1.3.6.1.2.1.6.10";
//    private final String tcpOutSegsOid = ".1.3.6.1.2.1.6.11";
//    private final String icmpInEchosOid = ".1.3.6.1.2.1.5.8";
//    private final String icmpOutEchosOid = ".1.3.6.1.2.1.5.21";
//    private final String ifInOctetos = ".1.3.6.1.2.1.2.2.1.10";
//    private final String ifOutOctetos = ".1.3.6.1.2.1.2.2.1.16";
    private static Network network;    

    public static void main(String[] args) throws Exception {
        network = new Network();
        System.out.println(network.getAgentByIp("192.168.0.11").getAgentInfo(".1.3.6.1.2.1.1.1.0"));
    }
}
