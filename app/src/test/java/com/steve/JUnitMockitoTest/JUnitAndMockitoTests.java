package com.steve.JUnitMockitoTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// JUnit and Mockito Test Samples.
public class JUnitAndMockitoTests {

    Calculator calculator = null;
    ProcessLogin login = null;
    RemoteService apiservice; //  = Mockito.mock(RemoteService.class);
    @Rule public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setup() {
        apiservice = Mockito.mock(RemoteService.class);
        calculator = new Calculator(apiservice);
        login = new ProcessLogin(apiservice);
    }

    @Test
    public void testAdd() {
        when(apiservice.add(2,3)).thenReturn(5);
        assertEquals(5, calculator.performAdd(2, 3));
        verify(apiservice).add(2, 3);
    }

    @Test
    public void testSquare() {
        calculator.performSquare(2);
        verify(apiservice).square(2);
    }

    @Test
    public void testValidUserName_With_Null_String() {
        assertEquals(false, login.validUserName(null));
        verify(apiservice, never()).Login(null, null);
    }

    @Test
    public void testValidUserName_With_Short_String() {
        String name = "ok";
        assertEquals(false, login.validUserName(name));
    }

    @Test
    public void testValidUserName_With_Proper_String() {
        String name = "okio7";
        assertEquals(true, login.validUserName(name));
    }

    @Test
    public void testValidUserName_With_Wrong_String() {
        String name = "9java";
        assertEquals(false, login.validUserName(name));
    }

    @Test
    public void testValidPassword_With_Null_String() {
        assertEquals(false, login.validPassword(null));
    }

    @Test
    public void testValidPassword_With_Short_String() {
        String password = "1234d";
        assertEquals(false, login.validPassword(password));
    }

    @Test
    public void testValidPassword_With_Proper_String() {
        String password = "Fhek8f2";
        assertEquals(true, login.validPassword(password));
    }

    @Test
    public void testLogin_Null_Name_Password() {
        login.UserLogin(null, null);
        verify(apiservice, never()).Login(null, null);
    }

    @Test
    public void testLogin_Null_Name_Normal_Password() {
        String password = "Fhek8f2";
        login.UserLogin(null, password);
        verify(apiservice, never()).Login(null, password);
    }

    @Test
    public void testLogin_Empty_Name_Normal_Password() {
        String password = "Fhek8f2";
        login.UserLogin("", password);
        verify(apiservice, never()).Login("", password);
    }

    @Test
    public void testLogin_Short_Name_Normal_Password() {
        String password = "Fhek8f2";
        String name = "ok";
        login.UserLogin(name, password);
        verify(apiservice, never()).Login(name, password);
    }

    @Test
    public void testLogin_Normal_Name_Normal_Password() {
        String name = "okio7";
        String password = "Fhek8f2";
        login.UserLogin(name, password);
        verify(apiservice).Login(name, password);
    }

    @Test
    public void testLogin_Normal_Name_Empty_Password() {
        String password = "";
        String name = "okio7";
        login.UserLogin(name, password);
        verify(apiservice, never()).Login(name, password);
    }

    @Test
    public void testLogin_Normal_Name_Short_Password() {
        String password = "short";
        String name = "okio7";
        login.UserLogin(name, password);
        verify(apiservice, never()).Login(name, password);
    }
}
