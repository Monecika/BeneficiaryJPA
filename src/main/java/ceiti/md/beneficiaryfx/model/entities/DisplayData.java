package ceiti.md.beneficiaryfx.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisplayData {
    private String codeBen;
    private String name;
    private String surname;
    private String phoneNumber;
    private String idnp;
    private String address;
    private String email;
    private String locality;
    private String environment;
    private String cardNumber;

    public DisplayData(String codeBen, String name, String surname, String phone, String address, String email) {
    }
}
