// Copyright (c) 2011 Belmont Technology Pty Ltd. All rights reserved.

package Example_02_LessSyntax

class ClassDeclarationSyntaxInScala {

  abstract class AbstractDTO(val id: Long)

  class CustomerDTO(id: Long, var name: String, var roles: List[String]) extends AbstractDTO(id)
}