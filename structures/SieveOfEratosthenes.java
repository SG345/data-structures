package structures;

/**
*Sieve of Eratosthenes
*
*@author: Devesh Shetty
*/
public class SieveOfEratosthenes{
    
    public SieveOfEratosthenes(){
        
    }
    
    /**
    *Print primes from 2 to n
    *
    *@param n the last integer
    */
    public static void printPrimes(int n){
        //we start by assuming all numbers are prime
        boolean[] prime = new boolean[n+1];//intialize n+1 locations for array
        
        for(int i = 2; i<= n;i++){
            prime[i] = true;//mark all nos as prime
        }
        
        //loop condition : divisor <= sqroot(n)
        for(int divisor = 2; divisor * divisor <= n; divisor++){
            
            if( prime[divisor] ){
                //if the divisor is a prime then mark all its multiples as non-prime;i.e., composite
                
                for(int i = ( divisor << 1 ); i <= n; i+= divisor ){
                    prime[i] = false;
                }
                
            }
            
        }
        
        for(int i = 2; i<=n;i++ ){
            if(prime[i]){
                //if the number is prime then print it
                System.out.print(i+" ");
            }
            
        }
        //go to a new line
        System.out.println();
        
        
        
    }
}