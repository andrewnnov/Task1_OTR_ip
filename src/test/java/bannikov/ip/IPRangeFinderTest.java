package bannikov.ip;

import org.junit.Assert;
import org.junit.Test;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class IPRangeFinderTest {

    @Test
    public void whenWePush2CorrectAddressThenWeHaveRange() {
        IpRangeFinder ipRangeFinder = new IpRangeFinder("192.168.0.1", "192.168.0.5");
        List<String> listIP = Arrays.asList("192.168.0.2", "192.168.0.3", "192.168.0.4");
        assertEquals(listIP, ipRangeFinder.getIpAddressesRange());
    }

    @Test
    public void whenWePush2EqualsAddressThenWeHaveRange0() {
        IpRangeFinder ipRangeFinder = new IpRangeFinder("192.168.0.5", "192.168.0.5");
        List<String> listIP = new ArrayList<>();
        assertEquals(listIP, ipRangeFinder.getIpAddressesRange());
    }

    @Test
    public void whenWePushIPAddressThenWeAcceptLong() throws UnknownHostException {
        IpRangeFinder ipRangeFinder = new IpRangeFinder();
        long result = ipRangeFinder.ipToLong(InetAddress.getByName("192.168.0.1"));
        long exp = 3_232_235_521L;
        assertEquals(3232235521L, result);
    }

    @Test
    public void whenWePushLongThenWeAcceptIP() {
        IpRangeFinder ipRangeFinder = new IpRangeFinder();
        String result = ipRangeFinder.longToIp(3_232_235_521L);
        String exp = "192.168.0.1";
        assertEquals(exp, result);
    }
}
