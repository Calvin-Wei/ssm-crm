package com.wxc.crm.util.common;

/**
 * MD5 32位加密用户密码
 */
public class MD5 {
    public MD5(Object ob){
        this();
        Update(ob.toString());
    }

    public MD5(){
        Init();
    }

    /**
     * 解码
     * @param buffer
     * @param len
     * @param shift
     * @return
     */
    private int[] Decode(byte buffer[],int len,int shift){
        int out[]=new int[16];
        int j;
        int i=j=0;
        for (;j<len;j+=4){
            out[i]=buffer[j+shift]&0xff
                    |(buffer[j+1+shift]&0xff)<<8
                    |(buffer[j+2+shift]&0xff)<<16
                    |(buffer[j+3+shift]&0xff)<<24;
            i++;
        }
        return out;
    }

    /**
     * 加密
     * @param input
     * @param len
     * @return
     */
    private byte[] Encode(int input[],int len){
        byte out[]=new byte[len];
        int j;
        int i=j=0;
        for (;j<len;j+=4){
            out[j]=(byte)(input[i] & 0xff);
            out[j+1]=(byte)(input[i]>>>8 & 0xff);
            out[j+2]=(byte)(input[i]>>>16 & 0xff);
            out[j+3]=(byte)(input[i]>>>24 & 0xff);
            i++;
        }
        return out;
    }

    private int FF(int a,int b,int c,int d,int x,int s ,int ac){
        a=uadd(a,b & c | ~b&d,x,ac);
        return uadd(rotate_left(a,s),b);
    }

    public synchronized byte[] Final(){
        if (finals==null){
            MD5State fin = new MD5State(state);
            byte bits[] = Encode(fin.count, 8);
            int index = fin.count[0] >>> 3 & 0x3f;
            int padlen = index >= 56 ? 120 - index : 56 - index;
            Update(fin, padding, 0, padlen);
            Update(fin, bits, 0, 8);
            finals = fin;
        }
        return Encode(finals.state, 16);
    }

    private int GG(int a, int b, int c, int d, int x, int s, int ac) {
        a = uadd(a, b & d | c & ~d, x, ac);
        return uadd(rotate_left(a, s), b);
    }

    private int HH(int a, int b, int c, int d, int x, int s, int ac) {
        a = uadd(a, b ^ c ^ d, x, ac);
        return uadd(rotate_left(a, s), b);
    }

    private int II(int a, int b, int c, int d, int x, int s, int ac) {
        a = uadd(a, c ^ (b | ~d), x, ac);
        return uadd(rotate_left(a, s), b);
    }

    public synchronized void Init() {
        state = new MD5State();
        finals = null;
    }

    private void Transform(MD5State state, byte buffer[], int shift) {
        int a = state.state[0];
        int b = state.state[1];
        int c = state.state[2];
        int d = state.state[3];
        int x[] = Decode(buffer, 64, shift);
        a = FF(a, b, c, d, x[0], 7, 0xd76aa478);
        d = FF(d, a, b, c, x[1], 12, 0xe8c7b756);
        c = FF(c, d, a, b, x[2], 17, 0x242070db);
        b = FF(b, c, d, a, x[3], 22, 0xc1bdceee);
        a = FF(a, b, c, d, x[4], 7, 0xf57c0faf);
        d = FF(d, a, b, c, x[5], 12, 0x4787c62a);
        c = FF(c, d, a, b, x[6], 17, 0xa8304613);
        b = FF(b, c, d, a, x[7], 22, 0xfd469501);
        a = FF(a, b, c, d, x[8], 7, 0x698098d8);
        d = FF(d, a, b, c, x[9], 12, 0x8b44f7af);
        c = FF(c, d, a, b, x[10], 17, -42063);
        b = FF(b, c, d, a, x[11], 22, 0x895cd7be);
        a = FF(a, b, c, d, x[12], 7, 0x6b901122);
        d = FF(d, a, b, c, x[13], 12, 0xfd987193);
        c = FF(c, d, a, b, x[14], 17, 0xa679438e);
        b = FF(b, c, d, a, x[15], 22, 0x49b40821);
        a = GG(a, b, c, d, x[1], 5, 0xf61e2562);
        d = GG(d, a, b, c, x[6], 9, 0xc040b340);
        c = GG(c, d, a, b, x[11], 14, 0x265e5a51);
        b = GG(b, c, d, a, x[0], 20, 0xe9b6c7aa);
        a = GG(a, b, c, d, x[5], 5, 0xd62f105d);
        d = GG(d, a, b, c, x[10], 9, 0x2441453);
        c = GG(c, d, a, b, x[15], 14, 0xd8a1e681);
        b = GG(b, c, d, a, x[4], 20, 0xe7d3fbc8);
        a = GG(a, b, c, d, x[9], 5, 0x21e1cde6);
        d = GG(d, a, b, c, x[14], 9, 0xc33707d6);
        c = GG(c, d, a, b, x[3], 14, 0xf4d50d87);
        b = GG(b, c, d, a, x[8], 20, 0x455a14ed);
        a = GG(a, b, c, d, x[13], 5, 0xa9e3e905);
        d = GG(d, a, b, c, x[2], 9, 0xfcefa3f8);
        c = GG(c, d, a, b, x[7], 14, 0x676f02d9);
        b = GG(b, c, d, a, x[12], 20, 0x8d2a4c8a);
        a = HH(a, b, c, d, x[5], 4, 0xfffa3942);
        d = HH(d, a, b, c, x[8], 11, 0x8771f681);
        c = HH(c, d, a, b, x[11], 16, 0x6d9d6122);
        b = HH(b, c, d, a, x[14], 23, 0xfde5380c);
        a = HH(a, b, c, d, x[1], 4, 0xa4beea44);
        d = HH(d, a, b, c, x[4], 11, 0x4bdecfa9);
        c = HH(c, d, a, b, x[7], 16, 0xf6bb4b60);
        b = HH(b, c, d, a, x[10], 23, 0xbebfbc70);
        a = HH(a, b, c, d, x[13], 4, 0x289b7ec6);
        d = HH(d, a, b, c, x[0], 11, 0xeaa127fa);
        c = HH(c, d, a, b, x[3], 16, 0xd4ef3085);
        b = HH(b, c, d, a, x[6], 23, 0x4881d05);
        a = HH(a, b, c, d, x[9], 4, 0xd9d4d039);
        d = HH(d, a, b, c, x[12], 11, 0xe6db99e5);
        c = HH(c, d, a, b, x[15], 16, 0x1fa27cf8);
        b = HH(b, c, d, a, x[2], 23, 0xc4ac5665);
        a = II(a, b, c, d, x[0], 6, 0xf4292244);
        d = II(d, a, b, c, x[7], 10, 0x432aff97);
        c = II(c, d, a, b, x[14], 15, 0xab9423a7);
        b = II(b, c, d, a, x[5], 21, 0xfc93a039);
        a = II(a, b, c, d, x[12], 6, 0x655b59c3);
        d = II(d, a, b, c, x[3], 10, 0x8f0ccc92);
        c = II(c, d, a, b, x[10], 15, 0xffeff47d);
        b = II(b, c, d, a, x[1], 21, 0x85845dd1);
        a = II(a, b, c, d, x[8], 6, 0x6fa87e4f);
        d = II(d, a, b, c, x[15], 10, 0xfe2ce6e0);
        c = II(c, d, a, b, x[6], 15, 0xa3014314);
        b = II(b, c, d, a, x[13], 21, 0x4e0811a1);
        a = II(a, b, c, d, x[4], 6, 0xf7537e82);
        d = II(d, a, b, c, x[11], 10, 0xbd3af235);
        c = II(c, d, a, b, x[2], 15, 0x2ad7d2bb);
        b = II(b, c, d, a, x[9], 21, 0xeb86d391);
        state.state[0] += a;
        state.state[1] += b;
        state.state[2] += c;
        state.state[3] += d;
    }

    public void Update(String s) {
        byte chars[] = s.getBytes();
        Update(chars, chars.length);
    }

    public void Update(byte b) {
        byte buffer[] = new byte[1];
        buffer[0] = b;
        Update(buffer, 1);
    }

    public void Update(byte buffer[]) {
        Update(buffer, 0, buffer.length);
    }

    public void Update(byte buffer[], int length) {
        Update(state, buffer, 0, length);
    }

    public void Update(byte buffer[], int offset, int length) {
        Update(state, buffer, offset, length);
    }

    public void Update(MD5State stat, byte buffer[], int offset, int length) {
        finals = null;
        if (length - offset > buffer.length)
            length = buffer.length - offset;
        int index = stat.count[0] >>> 3 & 0x3f;
        if ((stat.count[0] += length << 3) < length << 3)
            stat.count[1]++;
        stat.count[1] += length >>> 29;
        int partlen = 64 - index;
        int i;
        if (length >= partlen) {
            for (i = 0; i < partlen; i++)
                stat.buffer[i + index] = buffer[i + offset];

            Transform(stat, stat.buffer, 0);
            for (i = partlen; i + 63 < length; i += 64)
                Transform(stat, buffer, i);

            index = 0;
        } else {
            i = 0;
        }
        if (i < length) {
            int start = i;
            for (; i < length; i++)
                stat.buffer[(index + i) - start] = buffer[i + offset];

        }
    }

    public String asHex() {
        return asHex(Final());
    }

    public static String asHex(byte hash[]) {
        StringBuffer buf = new StringBuffer(hash.length * 2);
        for (int i = 0; i < hash.length; i++) {
            if ((hash[i] & 0xff) < 16)
                buf.append("0");
            buf.append(Long.toString(hash[i] & 0xff, 16));
        }

        return buf.toString();
    }

    public String debugDump() {
        return asHex();
    }

    public static String md5crypt(String input) {
        MD5 md5 = new MD5();
        md5.Init();
        md5.Update(input);
        return md5.asHex();
    }

    private int rotate_left(int x, int n) {
        return x << n | x >>> 32 - n;
    }

    private int uadd(int a, int b, int c, int d) {
        return uadd(uadd(a, b, c), d);
    }

    private int uadd(int a, int b, int c) {
        return uadd(uadd(a, b), c);
    }

    private int uadd(int a, int b) {
        long aa = (long) a & 0xffffffffL;
        long bb = (long) b & 0xffffffffL;
        aa += bb;
        return (int) (aa & 0xffffffffL);
    }

    MD5State finals;
    static byte padding[] = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0 };
    MD5State state;

}
