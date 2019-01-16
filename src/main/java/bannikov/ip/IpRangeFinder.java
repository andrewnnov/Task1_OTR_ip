package bannikov.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class IpRangeFinder {

    private static final long OCTET0 = 1 << 24;
    private static final long OCTET1 = 1 << 16;
    private static final long OCTET2 = 1 << 8;
    String startIpStr;
    String endIpStr;

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
            long firstIndex = ipToLong(firstOfRange);
            long endIndex = ipToLong(endOfRange);
            for (long i = firstIndex + 1; i < endIndex ; i++) {
                listRangeOfIP.add(longToIp(i));
            }
        }catch(UnknownHostException ex) {
            System.out.println(ex.toString());
        }
        return listRangeOfIP;
    }

    public long ipToLong(InetAddress inetAddress) {
        byte inetAddressByteAr[] = inetAddress.getAddress();

        int i0 = inetAddressByteAr[0];
        if (i0 < 0) {
            i0 += 256;
        }
        int i1 = inetAddressByteAr[1];
        if (i1 < 0) {
            i1 += 256;
        }
        int i2 = inetAddressByteAr[2];
        if (i2 < 0) {
            i2 += 256;
        }
        int i3 = inetAddressByteAr[3];
        if (i3 < 0) {
            i3 += 256;
        }
        return (OCTET0 * i0) + (OCTET1 * i1) + (OCTET2 * i2) + i3;
    }

    public String longToIp(long ip) {

        long a = ip;
        long r0 = a / OCTET0;
        a -= (r0 * OCTET0);
        long r1 = a / OCTET1;
        a -= (r1 * OCTET1);
        long r2 = a / OCTET2;
        a -= (r2 * OCTET2);
        long r3 = a;
        String ips = r0 + "." + r1 + "." + r2 + "." + r3;
        return ips;
    }
}
