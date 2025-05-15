package gamz.projects.pharmacyfair.service;

import gamz.projects.pharmacyfair.model.exception.BeansContextException;
import gamz.projects.pharmacyfair.model.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
@SuppressWarnings("unchecked")
public class EntityFetcher {

    private final ApplicationContext context;

    public <T> T fetchOneById(Class<T> className, Long id) {
        String repoBeanName = getRepoBeanName(className);
        try {
            CrudRepository<T, Long> repository = (CrudRepository<T, Long>) context.getBean(repoBeanName);
            return repository.findById(id)
                    .orElseThrow(() -> new NotFoundException(repoBeanName + " with ID = " + id + " not found"));
        } catch (NoSuchBeanDefinitionException e){
            throw new NotFoundException(repoBeanName + " repository not found");
        } catch (BeansException e) {
            throw new BeansContextException("Bean " + repoBeanName + " is unavailable");
        }
    }

    public <T> List<T> fetchAll(Class<T> className) {
        String repoBeanName = getRepoBeanName(className);
        try {
            CrudRepository<T, Long> repository = (CrudRepository<T, Long>) context.getBean(repoBeanName);
            return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
        } catch (NoSuchBeanDefinitionException e){
            throw new NotFoundException(repoBeanName + " repository not found");
        } catch (BeansException e) {
            throw new BeansContextException("Bean " + repoBeanName + " is unavailable");
        }
    }

    private String getRepoBeanName(Class<?> className) {
        String simpleName = className.getSimpleName() + "Repository";
        return Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
    }
}
