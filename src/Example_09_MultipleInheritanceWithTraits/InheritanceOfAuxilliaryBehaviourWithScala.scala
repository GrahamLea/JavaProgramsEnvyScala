package Example_09_MultipleInheritanceWithTraits

import collection.mutable.ListBuffer

object InheritanceOfAuxilliaryBehaviourWithScala {

  type Watcher[T] = T => Unit

  trait Watchable[T] {
    private val watchers = new ListBuffer[Watcher[T]]

    def addWatcher(watcher: Watcher[T]): Unit = watchers += watcher

    protected def notify(value: T): Unit = watchers.foreach { _(value) }
  }

  abstract class Repository[T] {
    def save(value: T): Unit = {
      // ...
    }
  }

  case class StockPrice(value: String)

  class StockMarket extends Repository[StockPrice] with Watchable[StockPrice] {
    override def save(value: StockPrice): Unit = {
      super.save(value)
      notify(value)
    }
  }

  def main(args: Array[String]) {
    val stockMarket = new StockMarket
    stockMarket.addWatcher(stockPrice => println(stockPrice))
    stockMarket.save(StockPrice("1.50"))
  }

}