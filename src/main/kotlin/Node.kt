data class Node<T>(var value: T, var nexNode: Node<T>? = null) {
   
  override fun toString(): String {
    return "$value"
  }
  
}
