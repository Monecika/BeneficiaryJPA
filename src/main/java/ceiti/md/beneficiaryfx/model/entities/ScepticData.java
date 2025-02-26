package ceiti.md.beneficiaryfx.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScepticData {
    private String codeBen;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private String email;
}
