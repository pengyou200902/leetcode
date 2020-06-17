package algorithm.String.p468;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-16 23:08
 * @Reference https://leetcode.com/problems/validate-ip-address/discuss/95484/pythonjava-easy-understand-solution/582524
 * @Reference https://leetcode.com/problems/validate-ip-address/discuss/95491/Java-Simple-Solution
 */
public class Solution {
    public String validIPAddress(String IP) {
        if (IP.length() < 7)    {return "Neither";}
        int ipv4 = 4;
        int ipv6 = 6;
        int neither = 0;
        int type = checkType(IP);
        if (type == neither)    {return "Neither";}
        else if (type == ipv4 && isIPv4(IP)) {
            return "IPv4";
        }
        else if (type == ipv6 && isIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    public boolean isIPv4(String IP) {
        int ipv4SegNum = 4;
        String[] segs = IP.split("\\.");
        if (segs.length != ipv4SegNum)   {return false;}
        for (String s: segs) {
            if (s.length() > 3) {return false;}
            try {
                int val = Integer.parseInt(s);
                boolean valid = String.valueOf(val).equals(s) && val >= 0 && val <= 255;
                if (!valid) {return false;}
            } catch (Exception e)   {return false;}
        }
        return true;
    }

    public boolean isIPv6(String IP) {
        int ipv6SegNum = 8;
        String[] segs = IP.split(":");
        if (segs.length != ipv6SegNum)   {return false;}
        for (String s: segs) {
            if (s.length() > 4) {return false;}
            try {
                int val = Integer.parseInt(s, 16);
                boolean valid = val >= 0 && val <= 0xffff && s.charAt(0) != '-';
                // boolean valid = Integer.parseInt(s, 16) >= 0 && s.charAt(0) != '-';
                if (!valid)  {return false;}
            } catch (Exception e)   {return false;}
        }
        return true;
    }

    public int checkType(String IP) {
        int ipv4 = 4;
        int ipv6 = 6;
        int neither = 0;
        char last = IP.charAt(IP.length() - 1);
        boolean validLast = (last >= '0' && last <= '9') || (last >= 'a' && last <= 'f') || (last >= 'A' && last <= 'F');
        if (!validLast) {return neither;}
        if (IP.indexOf(':') > -1) {
            return ipv6;
        }
        else if (IP.indexOf('.') > -1) {
            return ipv4;
        }
        return neither;
    }

    public static void main(String[] args) {
        String[] IPs = new String[]{
                "1e1.16.254.1",
                "172.16.254.1.",
                "01.01.01.01",
                "0.0.0.-0",
                "2001:0db8:85a3:0:0:8A2E:0370:7334:",
                "2001:0db8:85a3:0000:0:8A2E:0370:733a",
                "2001:0db8:85a3:033:0:8A2E:0370:7334",
                "2001:0db8:85a3:00000:0:8A2E:0370:7334"
        };
        Solution solution = new Solution();
        for (String testIP: IPs) {
            System.out.println(testIP);
            System.out.println(solution.validIPAddress(testIP));
        }
    }
    
}
