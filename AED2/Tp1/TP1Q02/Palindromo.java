class Palindromo
{
   public static boolean palin_interativo (String cadeia)
   {
      int t = cadeia.length()/2;
      int aux = cadeia.length() - 1;
      boolean resp = true;

      for(int i = 0; i < t; i++)
      {
         if( cadeia.charAt(i) != cadeia.charAt(aux - i))
         {
            resp = false;               
         }
                 
      }
      return resp;   
       
   }// fim palin_interativo()  
   
   public static void main (String [] args)
   {
      String[] entrada = new String[1000];
      String linha;
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
         boolean r = palin_interativo(entrada[i]);
         
         if(r == true)
         {
            MyIO.println("SIM");
         }
         else
         {
            MyIO.println("NAO");
         }
         
      }   
   }// fim main() 

}// fim Palidromo
