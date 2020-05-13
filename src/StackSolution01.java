import java.util.ArrayList;

public class StackSolution01<E> {
    private ArrayList<E> containor = new ArrayList<E>();

    public void push(E item){
        containor.add(item);
    }

    public E pop(){
        if(containor.isEmpty()){
            return null;
        }else{

            E res = containor.get(containor.size()-1);
            containor.remove(containor.size()-1);
            return res;
        }
    }

    public E top(){
        if(containor.isEmpty()){
            return null;
        }else{
            return containor.get(containor.size()-1);
        }
    }

    public boolean isEmpty(){
        if(containor.isEmpty())
            return true;
        else
            return false;
    }

}

class Queue<E> {
    StackSolution01<E> stack01 = new StackSolution01();
    StackSolution01<E> stack02 = new StackSolution01();

    public void push(E item){

        stack01.push(item);

    }

    public E pop(){
        if(!stack02.isEmpty()){
            return stack02.pop();
        }
        while(!stack01.isEmpty()){
            stack02.push(stack01.pop());
        }
        return stack02.pop();
    }
}







