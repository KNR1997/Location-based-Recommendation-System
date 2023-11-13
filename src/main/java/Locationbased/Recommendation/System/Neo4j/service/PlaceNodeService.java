package Locationbased.Recommendation.System.Neo4j.service;

import Locationbased.Recommendation.System.Neo4j.commons.CommonFunction;
import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceFeatureDTO;
import Locationbased.Recommendation.System.Neo4j.models.place.PlaceFeature;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.PlaceHasFeatureQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.PlaceNodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceNodeService implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(PlaceNodeService.class);

    private final PlaceNodeRepository placeNodeRepository;

    private final PlaceFeature placeFeature;

    public PlaceNodeService(PlaceNodeRepository placeNodeRepository,
                            PlaceFeature placeFeature) {
        this.placeNodeRepository = placeNodeRepository;
        this.placeFeature = placeFeature;
    }

    public PlaceFeatureDTO saveOrUpdatePlaceFeature(PlaceFeatureDTO updateDTO) {

        boolean isNew = (placeNodeRepository.placeHasSubCategoryRelationship(updateDTO.getPlaceName()) == null);
        placeFeature.setPlaceName(updateDTO.getPlaceName());
        List<PlaceHasFeatureQueryResult> placeHasFeatureQueryResults = null;
        List<String> subCategory = new ArrayList<>();

        if (!isNew) {
            List<String> existingSubCategory = placeNodeRepository.getPlaceSubCategory(updateDTO.getPlaceName());
            // remove duplicates
            List<?> subCategories = CommonFunction.getDifference(updateDTO.getSubCategory(), existingSubCategory);
            placeHasFeatureQueryResults =
                    placeNodeRepository.createPlaceAndSubCategoryRelationship(
                            updateDTO.getPlaceName(),
                            subCategories.toArray(new String[0]));

        } else {
            placeHasFeatureQueryResults = placeNodeRepository.createPlaceAndSubCategoryRelationship(updateDTO.getPlaceName(), updateDTO.getSubCategory().toArray(new String[0]));
        }
        for (PlaceHasFeatureQueryResult placeHasFeatureQueryResult : placeHasFeatureQueryResults) {
            subCategory.add(placeHasFeatureQueryResult.getSubCategory());
        }
        placeFeature.setSubCategory(subCategory);
        return new PlaceFeatureDTO(placeFeature);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("PlaceService created");

    }
}
