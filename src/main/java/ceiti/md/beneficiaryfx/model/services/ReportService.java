package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Beneficiaries;
import ceiti.md.beneficiaryfx.model.entities.DisplayData;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    private final DisplayDataService displayDataService;

    @Autowired
    public ReportService(DisplayDataService displayDataService) {
        this.displayDataService = displayDataService;
    }


    public String exportReport(String reportFormat) {
        String path = "src/main/resources/jasperReportsOfBen";
        List<DisplayData> displayDataList = displayDataService.findAll();

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:Simple_Blue.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(file.getAbsolutePath());

            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(displayDataList);
            Map<String, Object> hm = new HashMap<>();
            hm.put("Created By", "Learn code with me");

            JasperPrint jp = JasperFillManager.fillReport(jr,hm,ds);

            if(reportFormat.equalsIgnoreCase("html")){
                JasperExportManager.exportReportToHtmlFile(jp,path+"\\beneficiaries.html");
            }
            if(reportFormat.equalsIgnoreCase("pdf")){
                JasperExportManager.exportReportToPdfFile(jp,path+"\\beneficiaries.pdf");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }

        return "File created at path: " + path;
    }
}
