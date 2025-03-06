package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Beneficiaries;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    private final DataSource dataSource;

    @Autowired
    public ReportService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String generateBeneficiaryReport(List<Beneficiaries> beneficiaries) {

        // Load JRXML file from resources
        InputStream employeeReportStream = getClass().getResourceAsStream("/Cherry.jrxml");
        if (employeeReportStream == null) {
            throw new RuntimeException("Report template not found.");
        }

        try {
            // Compile the report
            JasperReport jasperReport = JasperCompileManager.compileReport(employeeReportStream);

            // Parameters for the report (add your parameters here if needed)
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("BeneficiariesList", beneficiaries);

            // Fill the report with data
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                    dataSource.getConnection());

            // Export the report to PDF
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("employeeReport.pdf"));

            SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
            reportConfig.setSizePageToContent(true);
            reportConfig.setForceLineBreakPolicy(false);

            SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
            exportConfig.setMetadataAuthor("baeldung");
            exportConfig.setEncrypted(true);
            exportConfig.setAllowedPermissionsHint("PRINTING");

            exporter.setConfiguration(reportConfig);
            exporter.setConfiguration(exportConfig);

            // Execute the export
            exporter.exportReport();

            return "employeeReport.pdf"; // Return the report file name
        } catch (JRException | SQLException e) {
            throw new RuntimeException("Error generating report", e);
        }
    }
}
