package model.logic;

public class ShellSort{
	
	public static boolean less(Comparable a, Comparable b)
	{
	    return a.compareTo(b)<0;
	}

	public static void exchange(Comparable[] a, int i, int j)
	{
		Comparable t = a[i];
	    a[i] = a[j];
	    a[j] = t;
	}	
	
	public static void shellSort(Comparable[] a)
	{
	    int N = a.length;
	    int h = 1;
	    while(h < N/3)
	        h = 3*h +1;
	    while (h >= 1)
	    {
	        for(int i = h; i<N;i++)
	        {
	            for(int j = i; j>=h && less(a[j],a[j-h]); j-=h)
	                exchange(a, j, j-h);
	        }

	        h = h/3;
	    }
	}
}
