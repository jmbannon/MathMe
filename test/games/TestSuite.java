/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Jesse
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    games.FlashMath_BinaryTest.class, 
    games.FlashMath_ToBinaryTest.class, 
    games.FlashMath_MainTest.class, 
    games.FlashMath_MultiplicationTest.class, 
    games.FlashMath_ExponentTest.class, 
    games.FlashMath_PlayerTest.class, 
    games.FlashMath_ArithmeticTest.class, 
    games.FlashMath_Abstract_QuestionTest.class})
public class TestSuite {}
