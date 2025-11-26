package com.github.lume.api.api.validations.course;

import com.github.lume.api.api.dto.course.CourseRequestDTO;
import com.github.lume.api.api.dto.lesson.LessonRequestDTO;
import com.github.lume.api.api.dto.module.ModuleRequestDTO;
import com.github.lume.api.api.exception.user.InvalidUserDataException;
import com.github.lume.api.api.validations.ValidationErrorRegistry;

import java.util.List;

public class DefaultCourseValidator implements CourseValidator, NameValidator, DescriptionValidator, EvaluationValidator, WorkloadValidator, TitleValidator {

    @Override
    public void validateCourseCreation(CourseRequestDTO request) {
        validateName(request.name());
        validateDescription(request.description());
        validateEvaluation(request.evaluation());
        validateWorkload(request.workload());

        List<ModuleRequestDTO> modules = request.modules();

        if(modules.isEmpty()) {
            ValidationErrorRegistry.addError("Adicione módulos");
            return;
        }

        for(ModuleRequestDTO module : modules) {
            validateTitle(module.title());

            List<LessonRequestDTO> lessons = module.lessons();

            if(lessons.isEmpty()) {
                ValidationErrorRegistry.addError("Adicione aulas");
                return;
            }

            for(LessonRequestDTO lesson : lessons) {
                validateName(lesson.name());
                validateDescription(lesson.description());

                if((lesson.url() == null || lesson.url().isEmpty()) && (lesson.file().length < 1)) {
                    ValidationErrorRegistry.addError("Informe o conteúdo da aula");
                }
            }
        }

        // retorna caso não haja erros na lista
        if (!ValidationErrorRegistry.hasErrors()) {
            return;
        }

        // captura a mensagem de erro
        String errorMessage = ValidationErrorRegistry.getErrorMessage();

        throw new InvalidUserDataException(errorMessage);
    }
}
