public class Bubblesort
{
	public static void main(String[] args) {
		int arr[]=new int[]{45,78,1,-3,0,56,66,42,89,65};
		int n=arr.length;
		for(int i=0;i<n;i++)
		{
		    boolean swap=false;
		    for(int j=0;j<n-1-i;j++)
		    {
		        if(arr[j] >arr[j+1])
		        {
		            int t=arr[j];
		            arr[j]=arr[j+1];
		            arr[j+1]=t;
		            swap=true;
		        }
		    }
		    if(swap==false)
		    break;
		}
		for(int i=0;i<n;i++)
		System.out.print(arr[i]+" ");
	}
}
