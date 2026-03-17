package Array;


public class DynamicArray <T>{

  private T[] dynamicArray; 
  private int dynamicArraySize = 0; 
  private int dynamicArrayCapacity = 0;
  private int currentIndex = 0; 


  public DynamicArray(){
    dynamicArray = (T[]) new Object[dynamicArrayCapacity];
    dynamicArraySize = 0; 
    dynamicArrayCapacity = 0;
    currentIndex = 0;
  }

  public DynamicArray(int initialCapacity){
    if (initialCapacity < 0){
      throw new IllegalArgumentException("Initial capacity cannot be negative. Please provide a non-negative integer.");
    }
    dynamicArray = (T[]) new Object[initialCapacity];
    dynamicArraySize = 0; 
    dynamicArrayCapacity = initialCapacity;
    currentIndex = 0;
  }

  public DynamicArray(int size){
    if (size < 0){
      throw new IllegalArgumentException("Size cannot be negative. Please provide a non-negative integer.");
    }
    dynamicArraySize = size; 
    dynamicArrayCapacity = size * 2;
    dynamicArray = (T[]) new Object[dynamicArrayCapacity];
    currentIndex = 0;
  }



  private void resizeArray(){
    dynamicArrayCapacity = dynamicArrayCapacity == 0 ? 1 : dynamicArrayCapacity * 2;
    T[] newArray = (T[]) new Object[dynamicArrayCapacity];

    for (int i = 0; i < dynamicArraySize; i++){
      newArray[i] = dynamicArray[i];
    }
    dynamicArray = newArray; 
  }


  public void append(T value){
    dynamicArray[currentIndex++] = value; 
    if (dynamicArraySize + 1 >= dynamicArrayCapacity){
      resizeArray();
    }
  }

  public int getSize(){
    return (int) this.dynamicArraySize;
  }

  public T getValue(int index){
    if (index < 0 || index >= this.dynamicArraySize){
      throw new IndexOutOfBoundsException("The index is out of bounds. Please provide an index between 0 and " + (this.dynamicArraySize - 1)); 
    }
    return this.dynamicArray[index];
  }

  public void setValue(int index, T value){
    if (index < 0 || index >= this.dynamicArraySize){
      throw new IndexOutOfBoundsException("The index is out of bounds. Please provide an index between 0 and " + (this.dynamicArraySize - 1)); 
    }
    this.dynamicArray[index] = value;

  }


  public void printArray(){
    for (int i = 0; i < dynamicArraySize; i++){
      System.out.println(dynamicArray[i]);
    }
    System.out.println("Size: " + this.dynamicArraySize);
    System.out.println("Capacity: " + this.dynamicArrayCapacity);
  }

}
