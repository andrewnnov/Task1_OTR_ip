package bannikov.ip;

import bannikov.ip.util.ConsoleHelper;

import java.util.List;

public class RangeIP {

    public static void main(String[] args) {
        String startIpStr = ConsoleHelper.getStrFromKb("Введите начальный ip адрес");
        String endIpStr   = ConsoleHelper.getStrFromKb("Введите конечный  ip адрес");
        List<String> ipAddressesRange = new IpRangeFinder(startIpStr, endIpStr).getIpAddressesRange();
        ipAddressesRange.stream().forEach(System.out::println);
    }
}
