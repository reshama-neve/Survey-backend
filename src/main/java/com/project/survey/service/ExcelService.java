package com.project.survey.service;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import com.project.survey.helper.ExcelHelper;
import com.project.survey.model.Question;
import com.project.survey.model.Response;
import com.project.survey.model.Survey;
import com.project.survey.repo.ResponseRepo;
import com.project.survey.repo.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class ExcelService {
    @Autowired
    ResponseRepo responseRepo;

    public ByteArrayInputStream load(Integer[] response_id) {


        List<Response> responseRepoAllById = responseRepo.findAllById(Arrays.asList(response_id));

        ByteArrayInputStream in = ExcelHelper.responseToExcel(responseRepoAllById);
        return in;
    }

}