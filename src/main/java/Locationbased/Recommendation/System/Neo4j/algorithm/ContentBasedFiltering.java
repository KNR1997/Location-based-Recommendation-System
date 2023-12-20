package Locationbased.Recommendation.System.Neo4j.algorithm;

import Locationbased.Recommendation.System.Neo4j.models.node.District;
import Locationbased.Recommendation.System.Neo4j.models.node.Place;
import Locationbased.Recommendation.System.Neo4j.models.node.Province;
import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.PlaceQueryResult;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.ProvinceQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.DistrictRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.PlaceNodeRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.ProvinceRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContentBasedFiltering {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private PlaceNodeRepository placeNodeRepository;

    public String[] contentBasedRecommendedPlaces(List<SubCategory> likeSubCategories, String location) {
        List<String> placesNameList = new ArrayList<>();
        Province province;

        // Extract subcategory IDs from likeSubCategories
        List<Long> subCategoryIds = likeSubCategories.stream()
                .map(SubCategory::getId)
                .collect(Collectors.toList());

        // get subCategories list by IDs
        List<SubCategory> subCategoryList = subCategoryRepository.findAllById(subCategoryIds);

        // get location details
        District district = districtRepository.findDistrictByname(location);
        ProvinceQueryResult provinceQueryResult = districtRepository.findProvince(district.getName());
        province = new Province(provinceQueryResult);

        // get all places in the province
        List<PlaceQueryResult> placeQueryResultList = provinceRepository.getAllPlacesInProvince(province.getName());

        // find places contain that likeSubCategories
        if (placeQueryResultList != null) {
            for (PlaceQueryResult placeQueryResult : placeQueryResultList) {
                Place place = placeQueryResult.getPlace();

                Optional<Place> optionalPlace = placeNodeRepository.findById(place.getId());

                // Retain only the subCategories that exist in both place.getSubCategories() and subCategoryList
                List<SubCategory> commonSubCategories = new ArrayList<>(optionalPlace.get().getSubCategories());
                commonSubCategories.retainAll(subCategoryList);

                // Check if commonSubCategories is not empty
                if (!commonSubCategories.isEmpty()) {
                    placesNameList.add(place.getName());
                } else {
                    System.out.println("Empty");
                }
            }
        } else {
            System.out.println("Something wrong");
        }


        return placesNameList.toArray(new String[0]);
    }

}
