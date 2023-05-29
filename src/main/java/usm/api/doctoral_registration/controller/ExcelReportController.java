package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.service.excel_report.ExcelReportService;

import org.springframework.http.HttpHeaders;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/excel")
@CrossOrigin(origins = {"http://localhost:3000"})
public class ExcelReportController {

    private final ExcelReportService excelReportService;


    @GetMapping("/student")
    public ResponseEntity<byte[]> studentReport(@RequestParam Map<String, String> params){
        byte[] report = excelReportService.generateStudentReport(params);

        HttpHeaders headers = generateHeaders();

        return ResponseEntity.ok()
                .headers(headers)
                .body(report);
    }

    private HttpHeaders generateHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "report.xlsx");
        return headers;
    }
}
