// https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html

/*
public class Arrays
extends Object
This class contains various methods for manipulating arrays (such as sorting and searching). This class also contains a static factory that allows arrays to be viewed as lists.
The methods in this class all throw a NullPointerException, if the specified array reference is null, except where noted.

The documentation for the methods contained in this class includes briefs description of the implementations. Such descriptions should be regarded as implementation notes, rather than parts of the specification. Implementors should feel free to substitute other algorithms, so long as the specification itself is adhered to. (For example, the algorithm used by sort(Object[]) does not have to be a MergeSort, but it does have to be stable.)

This class is a member of the Java Collections Framework.
*/

static <T> List<T>  asList(T... a)
static <T> int	    binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c)
static <T> T[]	    copyOf(T[] original, int newLength)
static <T> T[]    	copyOfRange(T[] original, int from, int to)
static boolean	    equals(T[] a, T[] a2)
static void	        fill(T[] a, int fromIndex, int toIndex, T val)
static <T> void	    sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c)
static String     	toString(T[] a)
