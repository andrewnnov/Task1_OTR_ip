package bannikov.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class IpRangeFinder {

    private static final long OCTET0 = 1 << 24;
    private static final long OCTET1 = 1 << 16;
    private static final long OCTET2 = 1 << 8;
    private String startIpStr;
    private String endIpStr;

    public IpRangeFinder() {
    }

    public IpRangeFinder(String startIpStr, String endIpStr) {
       this.startIpStr = startIpStr;
       this.endIpStr = endIpStr;
    }

    public List<String> getIpAddressesRange() {
        List<String> listRangeOfIP = new ArrayList<>();
        try {
            InetAddress firstOfRange= InetAddress.getByName(startIpStr);
            InetAddress endOfRange= InetAddress.getByName(endIpStr);
            long firstIndex = ipToLong(firstOfRange) + 1;
            long endIndex = ipToLong(endOfRange);
            for (long i = firstIndex; i < endIndex ; i++) {
                listRangeOfIP.add(longToIp(i));
            }
        }catch(UnknownHostException ex) {
            System.out.println(ex.toString());
        }
        return listRangeOfIP;
    }

    public long ipToLong(InetAddress inetAddress) {
        byte inetAddressByteAr[] = inetAddress.getAddress();

        int seg0 = inetAddressByteAr[0];
        if (seg0 < 0) {
            seg0 += 256;
        }
        int seg1 = inetAddressByteAr[1];
        if (seg1 < 0) {
            seg1 += 256;
        }
        int seg2 = inetAddressByteAr[2];
        if (seg2 < 0) {
            seg2 += 256;
        }
        int seg3 = inetAddressByteAr[3];
        if (seg3 < 0) {
            seg3 += 256;
        }
        return (OCTET0 * seg0) + (OCTET1 * seg1) + (OCTET2 * seg2) + seg3;
    }

    public String longToIp(long ip) {
        long seg0 = ip / OCTET0;
        ip -= (seg0 * OCTET0);
        long seg1 = ip / OCTET1;
        ip -= (seg1 * OCTET1);
        long seg = ip / OCTET2;
        ip -= (seg * OCTET2);
        long seg3 = ip;
        String ips = seg0 + "." + seg1 + "." + seg + "." + seg3;
        return ips;
    }
}
