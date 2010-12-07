<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
 
<html>
      <head>
            <title>testg</title>
      </head>
      <body>
            <f:view>
                              <h:panelGroup id="greeting" >
                                    <h:outputText value="Hello, " rendered="#{not empty collaborator.firstName}" />
                                    <h:outputText value="#{collaborator.firstName}" />
                                    <h:outputText value="!" rendered="#{not empty collaborator.firstName}" />
                              </h:panelGroup>
            </f:view>
      </body>
</html>

