package ����;

import java.util.HashMap;



    /**
     * 36������10����ת��˼·�� 1������HashMap���Ͷ������ڴ������'0'����ĸ'Z'36���ַ�ֵ����
     * 2. ��ֵģ��ȡ����㣬�ݹ����
     *
     * @author xiucai.yao
     *
     */
    public class Ten2ThirtySix {
        // ����36��������
        private static final String X36 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // �õ�36����ת��10���Ƶ�ֵ����
        private static HashMap<Character, Integer> thirysixToTen = createMapThirtysixToTen();
        // �õ�10����ת��36���Ƶ�ֵ����
        private static HashMap<Integer, Character> tenToThirtysix = createMapTenToThirtysix();
        // ���徲̬������
        private static int BASE = 36;

        private static HashMap<Character, Integer> createMapThirtysixToTen() {
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < X36.length(); i++) {
                // 0--0,... ..., Z -- 35�Ķ�Ӧ��Ž�ȥ
                map.put(X36.charAt(i), i);
            }
            return map;
        }

        private static HashMap<Integer, Character> createMapTenToThirtysix() {
            HashMap<Integer, Character> map = new HashMap<Integer, Character>();
            for (int i = 0; i < X36.length(); i++) {
                // 0--0,... ..., 35 -- Z�Ķ�Ӧ��Ž�ȥ
                map.put(i, X36.charAt(i));
            }
            return map;
        }

        /**
         * 36 to 10
         *
         * @param pStr 36�����ַ���
         * @return ʮ����
         */
        public static int ThirtysixToDeciaml(String pStr) {
            if (pStr == "")
                return 0;
            // Ŀ��ʮ��������ʼ��Ϊ0
            int deciaml = 0;
            // ��¼�η�,��ʼΪ36���Ƴ��� -1
            int power = pStr.length() - 1;
            // ��36�����ַ���ת����char[]
            char[] keys = pStr.toCharArray();
            for (int i = 0; i < pStr.length(); i++) {
                // �õ�36���ƶ�Ӧ��10������
                int value = thirysixToTen.get(keys[i]);
                deciaml = (int) (deciaml + value * Math.pow(BASE, power));
                // ִ����� �η��Լ�
                power--;
            }
            return deciaml;
        }

        /**
         * 10 to 36
         *
         * @param iSrc 10��������ֵ
         * @param pRet ��iSrcת����36�����Ժ���ַ���
         * @return 0�ɹ�������ʧ��
         */
        public static int DeciamlToThirtySix(int iSrc, String pRet) {
            String str = DeciamlToThirtySix(iSrc);
            if (str.equals(pRet)) {
                return 0;
            } else {
                return 1;
            }
        }

        /**
         * �õݹ���ʵ��10 to 36
         *
         * @param iSrc
         * @return
         */
        public static String DeciamlToThirtySix(int iSrc) {
            String result = "";
            int key;
            int value;

            key = iSrc / BASE;
            value = iSrc - key * BASE;
            if (key != 0) {
                result = result + DeciamlToThirtySix(key);
            }

            result = result + tenToThirtysix.get(value).toString();

            return result;
        }

        public static void main(String[] args) {
//            int x = ThirtysixToDeciaml("7VW");
//            System.out.println(x);

            String s = DeciamlToThirtySix(510);
            System.out.println(s);
        }
    }

