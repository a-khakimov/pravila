/*
rule = NoOptionGet
*/
package fix

import scala.language.higherKinds

object NoOptionGet {
  val option: Option[Int] = Some(42)
  option.get /* assert: NoOptionGet
  ^^^^^^^^^^
  Option.get is not allowed
  */

  Some(42).get /* assert: NoOptionGet
  ^^^^^^^^^^^^
  Option.get is not allowed
  */

  val some: Some[Int] = Some(42)
  some.get /* assert: NoOptionGet
  ^^^^^^^^
  Option.get is not allowed
  */

  Option(42).get /* assert: NoOptionGet
  ^^^^^^^^^^^^^^
  Option.get is not allowed
  */

  None.get /* assert: NoOptionGet
  ^^^^^^^^
  Option.get is not allowed
  */

  val none = None
  none.get /* assert: NoOptionGet
  ^^^^^^^^
  Option.get is not allowed
  */

  case class Test[F[_], T](value: T) {
    def get = 42
  }

  val test = Test[Option, (Int, Option[String])]((42, Option("Foo")))
  test.get
}
