class Q03
{
   public static String alg_cesar (String c)
   {
      String s = "";
      char aux; 
      int t = c.length() , convert;
      
      for(int i = 0; i < t; i++)
      {
         aux = c.charAt(i);
         convert = ((int)aux) + 3;
         aux = (char)convert;
         s = s + aux ; 
      
      }
      return s;
            
   }// fim alg_cesar()
   
   public static void main (String [] args)
   {
      String[] entrada = new String[1000];
      String linha,  r ;
      int numEntrada = 0;

      //Leitura da entrada padrao
      do 
      {
         entrada[numEntrada] = MyIO.readLine();
         
      } while (entrada[numEntrada++].equals("FIM") == false);
      
      numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

      //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
      for(int i = 0; i < numEntrada; i++)
      {
         r = alg_cesar(entrada[i]);
         MyIO.println(r);
      }
      
   }// fim main
   
}// fim class Q03
