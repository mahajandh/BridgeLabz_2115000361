public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        
        for (int size : sizes) {
            System.out.println("Operations Count: " + size);
            
            // String Concatenation
            long start = System.nanoTime();
            String str = "";
            for (int i = 0; i < size; i++) {
                str += "a";
            }
            long stringTime = System.nanoTime() - start;
            System.out.println("String Concatenation Time: " + stringTime / 1_000_000.0 + " ms");
            
            // StringBuilder Concatenation
            start = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append("a");
            }
            long stringBuilderTime = System.nanoTime() - start;
            System.out.println("StringBuilder Concatenation Time: " + stringBuilderTime / 1_000_000.0 + " ms");
            
            // StringBuffer Concatenation
            start = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < size; i++) {
                sbf.append("a");
            }
            long stringBufferTime = System.nanoTime() - start;
            System.out.println("StringBuffer Concatenation Time: " + stringBufferTime / 1_000_000.0 + " ms");
            
            System.out.println();
        }
    }
}
