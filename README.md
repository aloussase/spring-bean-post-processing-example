This codebase implements a sample `BeanPostProcessor` in a Spring Boot
application.

This one scans the codebase for classes in a specific package and returns
proxied objects that will perform null argument checking on all methods.

Spring Boot uses CGLib instead of JDK Proxies in order to be able to proxy any
class, whether it implements an interface or not.
