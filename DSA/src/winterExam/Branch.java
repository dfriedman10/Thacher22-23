package winterExam;
import java.util.ArrayList;

public class Branch<T> {

	ArrayList<Branch<T>> children = new ArrayList<Branch<T>>();
	
	T data;
	
	public Branch(T data) {
		this.data =data;
	}
	
	public Branch() {}
	
}
