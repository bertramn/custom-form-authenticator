# Example Custom Form Authenticator

## Install as EJB

Module will fail when installed as EJB

### Build and Install

```sh
mvn clean package
cp target/custom-form-authenticator.jar $JBOSS_HOME/standalone/deployments/.
```

### Configure the form Authenticator

1. Login to admin console

2. Select or create a new realm

3. Select Authentication menu on left hand side

4. Select Flows Tab

5. Select Browser from Drop Down

6. Click Copy

7. In new Flow, click Action on Username Password Form and select Delete

8. On Browser Forms click Action and select Add Execution

9. Select Custom Username Password Form from Menu

10. Move newly added Custom Username Password Form upwards above the OTP Form

11. Try to login - Boom

```
2018-03-19 00:51:43,333 WARN  [org.jboss.modules] (default task-33) Failed to define class com.github.bertramn.sso.authenticators.browser.CustomUsernamePasswordForm in Module "deployment.custom-form-authenticator.jar" from Service Module Loader: java.lang.NoClassDefFoundError: Failed to link com/github/bertramn/sso/authenticators/browser/CustomUsernamePasswordForm (Module "deployment.custom-form-authenticator.jar" from Service Module Loader): org/keycloak/authentication/authenticators/browser/UsernamePasswordForm
        at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
        at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
        at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
        at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
        at org.jboss.modules.ModuleClassLoader.defineClass(ModuleClassLoader.java:446)
        at org.jboss.modules.ModuleClassLoader.loadClassLocal(ModuleClassLoader.java:274)
        at org.jboss.modules.ModuleClassLoader$1.loadClassLocal(ModuleClassLoader.java:77)
        at org.jboss.modules.Module.loadModuleClass(Module.java:713)
        at org.jboss.modules.ModuleClassLoader.findClass(ModuleClassLoader.java:190)
        at org.jboss.modules.ConcurrentClassLoader.performLoadClassUnchecked(ConcurrentClassLoader.java:412)
        at org.jboss.modules.ConcurrentClassLoader.performLoadClass(ConcurrentClassLoader.java:400)
        at org.jboss.modules.ConcurrentClassLoader.loadClass(ConcurrentClassLoader.java:116)
        at com.github.bertramn.sso.authenticators.browser.CustomUsernamePasswordFormFactory.create(CustomUsernamePasswordFormFactory.java:54)
        at com.github.bertramn.sso.authenticators.browser.CustomUsernamePasswordFormFactory.create(CustomUsernamePasswordFormFactory.java:16)
        at org.keycloak.authentication.DefaultAuthenticationFlow.processFlow(DefaultAuthenticationFlow.java:164)
        at org.keycloak.authentication.DefaultAuthenticationFlow.processFlow(DefaultAuthenticationFlow.java:127)
        at org.keycloak.authentication.AuthenticationProcessor.authenticateOnly(AuthenticationProcessor.java:853)
        at org.keycloak.authentication.AuthenticationProcessor.authenticate(AuthenticationProcessor.java:722)
        at org.keycloak.protocol.AuthorizationEndpointBase.handleBrowserAuthenticationRequest(AuthorizationEndpointBase.java:145)
        at org.keycloak.protocol.oidc.endpoints.AuthorizationEndpoint.buildAuthorizationCodeAuthorizationResponse(AuthorizationEndpoint.java:395)
        at org.keycloak.protocol.oidc.endpoints.AuthorizationEndpoint.build(AuthorizationEndpoint.java:139)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.jboss.resteasy.core.MethodInjectorImpl.invoke(MethodInjectorImpl.java:140)
        at org.jboss.resteasy.core.ResourceMethodInvoker.invokeOnTarget(ResourceMethodInvoker.java:295)
        at org.jboss.resteasy.core.ResourceMethodInvoker.invoke(ResourceMethodInvoker.java:249)
        at org.jboss.resteasy.core.ResourceLocatorInvoker.invokeOnTargetObject(ResourceLocatorInvoker.java:138)
        at org.jboss.resteasy.core.ResourceLocatorInvoker.invoke(ResourceLocatorInvoker.java:107)
        at org.jboss.resteasy.core.ResourceLocatorInvoker.invokeOnTargetObject(ResourceLocatorInvoker.java:133)
        at org.jboss.resteasy.core.ResourceLocatorInvoker.invoke(ResourceLocatorInvoker.java:101)
        at org.jboss.resteasy.core.SynchronousDispatcher.invoke(SynchronousDispatcher.java:406)
        at org.jboss.resteasy.core.SynchronousDispatcher.invoke(SynchronousDispatcher.java:213)
        at org.jboss.resteasy.plugins.server.servlet.ServletContainerDispatcher.service(ServletContainerDispatcher.java:228)
        at org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher.service(HttpServletDispatcher.java:56)
        at org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher.service(HttpServletDispatcher.java:51)
        at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
        at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:85)
        at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:129)
        at org.keycloak.services.filters.KeycloakSessionServletFilter.doFilter(KeycloakSessionServletFilter.java:90)
        at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:61)
        at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
        at io.undertow.servlet.handlers.FilterHandler.handleRequest(FilterHandler.java:84)
        at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:62)
        at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36)
        at org.wildfly.extension.undertow.security.SecurityContextAssociationHandler.handleRequest(SecurityContextAssociationHandler.java:78)
        at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
        at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:131)
        at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:57)
        at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
        at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:46)
        at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:64)
        at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:60)
        at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:77)
        at io.undertow.security.handlers.NotificationReceiverHandler.handleRequest(NotificationReceiverHandler.java:50)
        at io.undertow.security.handlers.AbstractSecurityContextAssociationHandler.handleRequest(AbstractSecurityContextAssociationHandler.java:43)
        at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
        at org.wildfly.extension.undertow.security.jacc.JACCContextIdHandler.handleRequest(JACCContextIdHandler.java:61)
        at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
        at org.wildfly.extension.undertow.deployment.GlobalRequestControllerHandler.handleRequest(GlobalRequestControllerHandler.java:68)
        at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
        at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:292)
        at io.undertow.servlet.handlers.ServletInitialHandler.access$100(ServletInitialHandler.java:81)
        at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:138)
        at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:135)
        at io.undertow.servlet.core.ServletRequestContextThreadSetupAction$1.call(ServletRequestContextThreadSetupAction.java:48)
        at io.undertow.servlet.core.ContextClassLoaderSetupAction$1.call(ContextClassLoaderSetupAction.java:43)
        at org.wildfly.extension.undertow.security.SecurityContextThreadSetupAction.lambda$create$0(SecurityContextThreadSetupAction.java:105)
        at org.wildfly.extension.undertow.deployment.UndertowDeploymentInfoService$UndertowThreadSetupAction.lambda$create$0(UndertowDeploymentInfoService.java:1508)
        at org.wildfly.extension.undertow.deployment.UndertowDeploymentInfoService$UndertowThreadSetupAction.lambda$create$0(UndertowDeploymentInfoService.java:1508)
        at org.wildfly.extension.undertow.deployment.UndertowDeploymentInfoService$UndertowThreadSetupAction.lambda$create$0(UndertowDeploymentInfoService.java:1508)
        at org.wildfly.extension.undertow.deployment.UndertowDeploymentInfoService$UndertowThreadSetupAction.lambda$create$0(UndertowDeploymentInfoService.java:1508)
        at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:272)
        at io.undertow.servlet.handlers.ServletInitialHandler.access$000(ServletInitialHandler.java:81)
        at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:104)
        at io.undertow.server.Connectors.executeRootHandler(Connectors.java:326)
        at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:812)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
        at java.lang.Thread.run(Thread.java:748)

2018-03-19 00:51:43,437 ERROR [org.keycloak.services.error.KeycloakErrorHandler] (default task-33) Uncaught server error: java.lang.NoClassDefFoundError: Failed to link com/github/bertramn/sso/authenticators/browser/CustomUsernamePasswordForm (Module "deployment.custom-form-authenticator.jar" from Service Module Loader): org/keycloak/authentication/authenticators/browser/UsernamePasswordForm
        at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
        at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
        at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
        at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
        at org.jboss.modules.ModuleClassLoader.defineClass(ModuleClassLoader.java:446)
        at org.jboss.modules.ModuleClassLoader.loadClassLocal(ModuleClassLoader.java:274)
        at org.jboss.modules.ModuleClassLoader$1.loadClassLocal(ModuleClassLoader.java:77)
        at org.jboss.modules.Module.loadModuleClass(Module.java:713)
        at org.jboss.modules.ModuleClassLoader.findClass(ModuleClassLoader.java:190)
        at org.jboss.modules.ConcurrentClassLoader.performLoadClassUnchecked(ConcurrentClassLoader.java:412)
        at org.jboss.modules.ConcurrentClassLoader.performLoadClass(ConcurrentClassLoader.java:400)
        at org.jboss.modules.ConcurrentClassLoader.loadClass(ConcurrentClassLoader.java:116)
        at com.github.bertramn.sso.authenticators.browser.CustomUsernamePasswordFormFactory.create(CustomUsernamePasswordFormFactory.java:54)
        at com.github.bertramn.sso.authenticators.browser.CustomUsernamePasswordFormFactory.create(CustomUsernamePasswordFormFactory.java:16)
        at org.keycloak.authentication.DefaultAuthenticationFlow.processFlow(DefaultAuthenticationFlow.java:164)
        at org.keycloak.authentication.DefaultAuthenticationFlow.processFlow(DefaultAuthenticationFlow.java:127)
        at org.keycloak.authentication.AuthenticationProcessor.authenticateOnly(AuthenticationProcessor.java:853)
        at org.keycloak.authentication.AuthenticationProcessor.authenticate(AuthenticationProcessor.java:722)
        at org.keycloak.protocol.AuthorizationEndpointBase.handleBrowserAuthenticationRequest(AuthorizationEndpointBase.java:145)
        at org.keycloak.protocol.oidc.endpoints.AuthorizationEndpoint.buildAuthorizationCodeAuthorizationResponse(AuthorizationEndpoint.java:395)
        at org.keycloak.protocol.oidc.endpoints.AuthorizationEndpoint.build(AuthorizationEndpoint.java:139)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.jboss.resteasy.core.MethodInjectorImpl.invoke(MethodInjectorImpl.java:140)
        at org.jboss.resteasy.core.ResourceMethodInvoker.invokeOnTarget(ResourceMethodInvoker.java:295)
        at org.jboss.resteasy.core.ResourceMethodInvoker.invoke(ResourceMethodInvoker.java:249)
        at org.jboss.resteasy.core.ResourceLocatorInvoker.invokeOnTargetObject(ResourceLocatorInvoker.java:138)
        at org.jboss.resteasy.core.ResourceLocatorInvoker.invoke(ResourceLocatorInvoker.java:107)
        at org.jboss.resteasy.core.ResourceLocatorInvoker.invokeOnTargetObject(ResourceLocatorInvoker.java:133)
        at org.jboss.resteasy.core.ResourceLocatorInvoker.invoke(ResourceLocatorInvoker.java:101)
        at org.jboss.resteasy.core.SynchronousDispatcher.invoke(SynchronousDispatcher.java:406)
        at org.jboss.resteasy.core.SynchronousDispatcher.invoke(SynchronousDispatcher.java:213)
        at org.jboss.resteasy.plugins.server.servlet.ServletContainerDispatcher.service(ServletContainerDispatcher.java:228)
        at org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher.service(HttpServletDispatcher.java:56)
        at org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher.service(HttpServletDispatcher.java:51)
        at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
        at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:85)
        at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:129)
        at org.keycloak.services.filters.KeycloakSessionServletFilter.doFilter(KeycloakSessionServletFilter.java:90)
        at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:61)
        at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
        at io.undertow.servlet.handlers.FilterHandler.handleRequest(FilterHandler.java:84)
        at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:62)
        at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36)
        at org.wildfly.extension.undertow.security.SecurityContextAssociationHandler.handleRequest(SecurityContextAssociationHandler.java:78)
        at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
        at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:131)
        at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:57)
        at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
        at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:46)
        at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:64)
        at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:60)
        at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:77)
        at io.undertow.security.handlers.NotificationReceiverHandler.handleRequest(NotificationReceiverHandler.java:50)
        at io.undertow.security.handlers.AbstractSecurityContextAssociationHandler.handleRequest(AbstractSecurityContextAssociationHandler.java:43)
        at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
        at org.wildfly.extension.undertow.security.jacc.JACCContextIdHandler.handleRequest(JACCContextIdHandler.java:61)
        at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
        at org.wildfly.extension.undertow.deployment.GlobalRequestControllerHandler.handleRequest(GlobalRequestControllerHandler.java:68)
        at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
        at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:292)
        at io.undertow.servlet.handlers.ServletInitialHandler.access$100(ServletInitialHandler.java:81)
        at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:138)
        at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:135)
        at io.undertow.servlet.core.ServletRequestContextThreadSetupAction$1.call(ServletRequestContextThreadSetupAction.java:48)
        at io.undertow.servlet.core.ContextClassLoaderSetupAction$1.call(ContextClassLoaderSetupAction.java:43)
        at org.wildfly.extension.undertow.security.SecurityContextThreadSetupAction.lambda$create$0(SecurityContextThreadSetupAction.java:105)
        at org.wildfly.extension.undertow.deployment.UndertowDeploymentInfoService$UndertowThreadSetupAction.lambda$create$0(UndertowDeploymentInfoService.java:1508)
        at org.wildfly.extension.undertow.deployment.UndertowDeploymentInfoService$UndertowThreadSetupAction.lambda$create$0(UndertowDeploymentInfoService.java:1508)
        at org.wildfly.extension.undertow.deployment.UndertowDeploymentInfoService$UndertowThreadSetupAction.lambda$create$0(UndertowDeploymentInfoService.java:1508)
        at org.wildfly.extension.undertow.deployment.UndertowDeploymentInfoService$UndertowThreadSetupAction.lambda$create$0(UndertowDeploymentInfoService.java:1508)
        at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:272)
        at io.undertow.servlet.handlers.ServletInitialHandler.access$000(ServletInitialHandler.java:81)
        at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:104)
        at io.undertow.server.Connectors.executeRootHandler(Connectors.java:326)
        at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:812)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
        at java.lang.Thread.run(Thread.java:748)
```


## Install As Module

When installed as a module, the adapter works.

### Build and Install

```bash
# build me
mvn clean package

# install module
mkdir -p "${JBOSS_HOME}/modules/com/github/bertramn/sso/authenticators/browser/custom-form-authenticator/main"
cp src/main/resources/module.xml "${JBOSS_HOME}/modules/com/github/bertramn/sso/authenticators/browser/custom-form-authenticator/main"
cp target/custom-form-authenticator.jar "${JBOSS_HOME}/modules/com/github/bertramn/sso/authenticators/browser/custom-form-authenticator/main/."

# configure provider
${JBOSS_HOME}/bin/jbosscli.sh -c '/subsystem=keycloak-server:list-add(name=providers,value=module:com.github.bertramn.sso.authenticators.browser.custom-form-authenticator)'

# start server
$(JBOSS_HOME)/bin/standalone.sh
```

Follow [form setup](https://github.com/bertramn/custom-form-authenticator#configure-the-form-authenticator) above.
