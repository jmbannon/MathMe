/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Jesse
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    question.Question_AbstractTest.class, 
    question.Question_MultipleChoiceTest.class, 
    question.Question_CheckBoxTest.class, 
    question.Question_TextBoxTest.class,
    question.Question_TrueFalseTest.class})
public class TestSuite {}