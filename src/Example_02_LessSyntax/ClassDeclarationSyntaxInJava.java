package Example_02_LessSyntax;

import java.util.List;

public class ClassDeclarationSyntaxInJava {
    
    public abstract class AbstractDTO {
        private final Long id;

        public AbstractDTO(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

    public class CustomerDTO extends AbstractDTO {
        private String name;
        private List<String> roles;

        public CustomerDTO(Long id, String name, List<String> roles) {
            super(id);
            this.name = name;
            this.roles = roles;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }
    }
}
