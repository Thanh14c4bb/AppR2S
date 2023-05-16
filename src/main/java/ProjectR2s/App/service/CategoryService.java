package ProjectR2s.App.service;

import ProjectR2s.App.entity.Category;
import ProjectR2s.App.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }
}