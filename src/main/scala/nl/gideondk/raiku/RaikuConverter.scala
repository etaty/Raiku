package nl.gideondk.raiku

import scalaz._
import Scalaz._

import nl.gideondk.raiku.commands.RWObject

/** Type class for writing and reading to and from RWObjects
 */

trait RaikuConverter[T] {
  type ReadResult[T] = Validation[Throwable, T]

  def read(o: RWObject): ReadResult[T]

  def write(bucket: String, o: T): RWObject
}