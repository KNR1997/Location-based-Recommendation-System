package Locationbased.Recommendation.System.Neo4j.service;

import Locationbased.Recommendation.System.Neo4j.commons.CommonFunction;
import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceFeatureDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceRateDTO;
import Locationbased.Recommendation.System.Neo4j.models.node.Place;
import Locationbased.Recommendation.System.Neo4j.models.node.PlaceFeature;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.PlaceHasFeatureQueryResult;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserRatePlaceQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.PlaceNodeRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserNodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceNodeService implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(PlaceNodeService.class);

    @Autowired
    private PlaceNodeRepository placeNodeRepository;

    @Autowired
    private PlaceFeature placeFeature;

    @Autowired
    private UserNodeRepository userNodeRepository;

    public PlaceDTO saveOrUpdatePlace(PlaceDTO updateDTO) {

        Place place;
        boolean isNewPlace = (updateDTO.getPlaceID() == null);

        if (!isNewPlace) {
            place = this.placeNodeRepository.findPlaceByID(updateDTO.getPlaceID());

        } else {
            place = new Place();

        }
        place.setName(updateDTO.getName());
        place.setDistricts(updateDTO.getDistricts());
        place.setSubCategories(updateDTO.getSubCategories());
        place.setPlaceCategories(updateDTO.getPlaceCategories());

        place = this.placeNodeRepository.save(place);
        return new PlaceDTO(place);
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

    public List<Place> getAllPlaces() {
        return placeNodeRepository.findAll();
    }

    public PlaceRateDTO ratePlace(PlaceRateDTO updateDTO) {
        UserRatePlaceQueryResult result = placeNodeRepository.ratePlace(
                updateDTO.getUserName(),
                updateDTO.getPlaceName(),
                updateDTO.getRating());

        return new PlaceRateDTO(result);
    }

    public Place getPlace(String placeName) {
        return placeNodeRepository.findPlaceByname(placeName);
    }
}
