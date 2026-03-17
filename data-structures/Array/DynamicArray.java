


public class DynamicArray <T>{

  private T[] dynamicArray; 
  private int dynamicArraySize = 0; 
  private int dynamicArrayCapacity = 0;
  private int currentIndex = 0; 


  public DynamicArray(){
    dynamicArrayCapacity = 1;
    dynamicArray = (T[]) new Object[dynamicArrayCapacity];
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


  private void resizeArray(){
    dynamicArrayCapacity = dynamicArrayCapacity == 0 ? 1 : dynamicArrayCapacity * 2;
    T[] newArray = (T[]) new Object[dynamicArrayCapacity];

    for (int i = 0; i < dynamicArraySize; i++){
      newArray[i] = dynamicArray[i];
    }
    dynamicArray = newArray; 
  }


  public void append(T value){
    if (dynamicArraySize + 1 >= dynamicArrayCapacity){
      resizeArray();
    }
    dynamicArray[currentIndex++] = value; 
  }

  public T remove(int index){
    if (index < 0 || index >= this.dynamicArraySize){
      throw new IndexOutOfBoundsException("The index is out of bounds. Please provide an index between 0 and " + (this.dynamicArraySize - 1)); 
    }
    T removedValue = dynamicArray[index];
    for (int i = index; i < dynamicArraySize - 1; i++){
      dynamicArray[i] = dynamicArray[i + 1];
    }
    dynamicArray[--dynamicArraySize] = null;
    return removedValue;
  }

  public void insert(int index, T value){
    if (index < 0 || index >= this.dynamicArraySize){
      throw new IndexOutOfBoundsException("The index is out of bounds. Please provide an index between 0 and " + (this.dynamicArraySize - 1)); 
    }

    if (dynamicArraySize >= dynamicArrayCapacity){
      resizeArray();
    }

    for (int i = dynamicArraySize; i > index; i--){
      dynamicArray[i] = dynamicArray[i-1]; 
    }
    dynamicArray[index] = value; 
    dynamicArraySize++;
  }


  public int getSize(){
    return this.dynamicArraySize;
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

  public boolean isEmpty(){
    return this.dynamicArraySize == 0;
  }

  public void clear(){
    for (int i = 0; i < dynamicArraySize; i++){
      dynamicArray[i] = null;
    }
    dynamicArraySize = 0;
  }

  public void printArray(){
    for (int i = 0; i < dynamicArraySize; i++){
      System.out.println(dynamicArray[i]);
    }
    System.out.println("Size: " + this.dynamicArraySize);
    System.out.println("Capacity: " + this.dynamicArrayCapacity);
  }

}
