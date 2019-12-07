package elalto.network.entities;

import java.util.List;

public class RegisterError {

    /**
     * message : The given data was invalid.
     * errors : {"ci":["El campo ci ya está siendo utilizado."],"celular":["El campo celular ya está siendo utilizado."],"email":["El campo email ya está siendo utilizado."],"password":["El campo de confirmación de password no coincide."]}
     */

    private String message;
    private ErrorsBean errors;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorsBean getErrors() {
        return errors;
    }

    public void setErrors(ErrorsBean errors) {
        this.errors = errors;
    }

    public static class ErrorsBean {
        private List<String> ci;
        private List<String> celular;
        private List<String> email;
        private List<String> password;

        public List<String> getCi() {
            return ci;
        }

        public void setCi(List<String> ci) {
            this.ci = ci;
        }

        public List<String> getCelular() {
            return celular;
        }

        public void setCelular(List<String> celular) {
            this.celular = celular;
        }

        public List<String> getEmail() {
            return email;
        }

        public void setEmail(List<String> email) {
            this.email = email;
        }

        public List<String> getPassword() {
            return password;
        }

        public void setPassword(List<String> password) {
            this.password = password;
        }
    }
}
