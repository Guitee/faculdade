class Celula 
{
   public int elemento;
   public Celula inf, sup, esq, dir;
 
   public Celula()
   {
      this(0, null, null, null, null);
   }//fim Construtor padrao
 
   public Celula(int elemento)
   {
      this(elemento, null, null, null, null);
   }
 
   public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir)
   {
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.esq = esq;
      this.dir = dir;
   }
}// fim class Celula
   
class Matriz 
{
   private Celula inicio;
   private int linha, coluna;
 
   public Matriz ()
   {
      this(3, 3);
   }//fim construtor vazio
   
   //alocar a matriz com this.linha linhas e this.coluna colunas
   public Matriz (int linha, int coluna)
   {
      this.linha = linha;
      this.coluna = coluna;
      Celula col = null;

      for(int i = 0; i < coluna; i++)
      {  
        Celula lin = null;
           
        for(int j = 0; j < linha; j++)
        {
          Celula tmp = new Celula();

          if(lin == null  && col == null)// inicializa  a celula tmp com o inicio 
          {
            inicio = tmp;
          }
        
          if(lin!= null)// ira montar a linha 
          {
            lin.dir = tmp;
            tmp.esq = lin; 
          }

          if(col!=null) // ira montar a coluna 
          {
            col.inf = tmp;
            tmp.sup = col;
          }

          lin = tmp;//aponta lin pra tmp
          
          if(col!=null)
          {
            col = col.dir;
          }  

        }

        while(lin.esq != null)
        {
           lin = lin.esq;   
        }
        col = lin; //aponta col pra lin  
            
      }  
      
   }//fim construor
 
   public static Matriz soma (Matriz m, Matriz n) 
   {
      Matriz resp = null;
      
      if( m.linha == n.linha && m.coluna == n.coluna )
      {
         resp = new Matriz( m.linha, n.coluna);
         
         for(Celula i = resp.inicio, k = m.inicio, h = n.inicio; 
            i.inf != null && k.inf != null && h.inf != null; i = i.inf, k = k.inf,h = h.inf)
         {
           for(Celula j = i,l = k, o = h;
            j.dir != null && l.dir != null && o.dir != null; j = j.dir, l = l.dir, o = o.dir)
           {
              j.elemento = l.elemento + o.elemento;                       
           }      
         }        
      }
 
      return resp;
   }// fim soma()
  
   
   public Matriz multiplicacao (Matriz m, Matriz n) 
   {
      Matriz resp = null;
      int soma 
 
      if(m.coluna == n.linha)
      {
         resp = new Matriz(m.linha, n.coluna);

         for(Celula i = resp.inicio , k = m.inicio, h = k; i!=null , k!= null; i = i.inf, k = k.inf)
         {
           for(Celula j = i, o = k; j!= null; k!=null; j=j.dir; o = o.inf)
           {
             soma+=
          }  
         }                      
          
               
                                     
                 
      }
         

      }
 
      return resp;
   }
   
   public boolean isQuadrada()
   {
      boolean (this.linha == this.coluna);
   }
   /* 
   public void mostrarDiagonalPrincipal ()
   {
      if(isQuadrada() == true){
         for(Celula i = inicio; i != null; i = i.inf.dir){
            Sop(i.elemento);
         }
      }
   }
 
   public void mostrarDiagonalSecundaria ()
   {
      if(isQuadrada() == true){
 
      }
   }
 
   public void mostrar()
   {
      for(Celula i = inicio; i != null; i = i.prox)
      {
         for(Celula j = 
   }
   */
}//fim class Matriz 

public class Q05
{
   public static void main (String [] args)
   {
      Matriz m1  = new Matriz(4,4);
      Matriz m2  = new Matriz(4,4);
      //Matriz s = Matriz.soma(m1,m2);
   }

}//fim class Q05