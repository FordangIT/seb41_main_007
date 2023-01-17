package com.bzzzzz.farm.question.entity.questionanswer;

import com.bzzzzz.farm.audit.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class QuestionAnswer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionAnswerId;

    @Column(nullable = false)
    private String questionAnswerTitle;

    @Column(nullable = false)
    private String questionAnswerContent;

}
