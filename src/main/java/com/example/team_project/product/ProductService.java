package com.example.team_project.product;

import com.example.team_project._core.erroes.exception.Exception404;
import com.example.team_project._core.vo.MyPath;
import com.example.team_project.product.ProductRequest.ProductUpdateReqDTO;
import com.example.team_project.product.product_book_mark.ProductBookmark;
import com.example.team_project.product.product_book_mark.ProductBookmarkJPARepository;
import com.example.team_project.product.product_pic.ProductPic;
import com.example.team_project.product.product_pic.ProductPicJPARepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductJPARepository productJPARepository;
    private final ProductPicJPARepository productPicJPARepository;
    private final ProductBookmarkJPARepository productBookMarkJPARepository;
    private final EntityManager em;
    private final HttpSession session;

    // 상품 목록 보기
    public List<ProductResponse.ProductListRespDTO> findAll() {
        List<Product> dtos = productJPARepository.findAll();

        List<ProductResponse.ProductListRespDTO> responseDTO = dtos.stream()
                .distinct()
                .map(p -> {
                    ProductResponse.ProductListRespDTO productDTO = new ProductResponse.ProductListRespDTO(p);
                    List<ProductResponse.ProductListRespDTO.ProductPicDTO> productPicDTOs = p.getProductPics().isEmpty()
                            ? null
                            : p.getProductPics().stream()
                                    .limit(1)
                                    .map(pp -> new ProductResponse.ProductListRespDTO.ProductPicDTO(pp))
                                    .collect(Collectors.toList());
                    productDTO.setProductPics((productPicDTOs));
                    return productDTO;
                })
                .collect(Collectors.toList());

        return responseDTO;
    }

    // 상품 상세보기
    public ProductResponse.ProductDetailRespDTO FindById(Integer id) {

        Product product = productJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("상품을 찾을 수 없습니다. ID: " + id));

        List<ProductPic> productPics = productPicJPARepository.findByProductId(product.getId());
        // TODO: productPics에 값이 없으면 빈 리스트가 아닌 null이 출력되게 수정해야 함
        return new ProductResponse.ProductDetailRespDTO(product, productPics);
    }

    // 상품 등록
    @Transactional
    public ProductResponse.ProductWriteRespDTO saveProductWithProductPics(
            ProductRequest.ProductWriteReqDTO productWriteReqDTO, Session sessionUser) {
        Product product = productJPARepository.save(productWriteReqDTO.toEntity());
        List<String> productPicList = productWriteReqDTO.getProductPics();

        for (String productPic : productPicList) {
            try {
                byte[] productImages = Base64.getDecoder().decode(productPic);
                UUID uuid = UUID.randomUUID();
                String filename = product.getProductName() + "_" + uuid + ".png";
                Path filePath = Paths.get(MyPath.IMG_PATH, filename);
                Files.write(filePath, productImages);
                String productPicUrl = filePath.toString();
                productPicJPARepository.mSave(productPicUrl, product.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(sessionUser);

        List<ProductPic> productPics = productPicJPARepository.findByProductId(product.getId());

        return new ProductResponse.ProductWriteRespDTO(product, productPics, sessionUser);

    }

    // 상품 수정
    @Transactional
    public ProductResponse.ProductUpdateRespDTO updateProductWithProductPics(Integer id,
            ProductUpdateReqDTO productUpdateReqDTO) {
        Product product = productJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("게시글을 찾을 수 없습니다. " + id));

        productJPARepository.mUpdateProduct(
                product.getId(),
                productUpdateReqDTO.getProductPrice(),
                productUpdateReqDTO.getProductDescription(),
                productUpdateReqDTO.getProductName());

        // 1. 해당 보드 id에 담긴 원래 사진들을 삭제.
        productPicJPARepository.deleteByProductId(product.getId());
        // 2. DTO에 담겨있던 사진을 저장.
        List<String> productPicList = productUpdateReqDTO.getProductPics();

        for (String productPic : productPicList) {

            productPicJPARepository.mSave(productPic, product.getId());
        }
        em.refresh(product);
        List<ProductPic> productPicsUpdate = productPicJPARepository.findByProductId(product.getId());

        return new ProductResponse.ProductUpdateRespDTO(product, productPicsUpdate);
    }

    @Transactional
    public void deleteProduct(int productId) {
        // 먼저 해당 게시글의 이미지를 삭제
        // List<ProductPic> productPics =
        // productPicJPARepository.findByProductId(productId);
        // for (ProductPic productPic : productPics) {
        // productPicJPARepository.delete(productPic);
        // }
        // 그 다음 게시글을 삭제
        productJPARepository.deleteById(productId);
    }

    // 상품 검색
    public List<ProductResponse.ProductSearchRespDTO> searchProductsByKeyword(String keyword) {
        List<Product> productList = productJPARepository.findByProductNameContaining(keyword);

        List<ProductResponse.ProductSearchRespDTO> responseDTO = productList.stream()
                .distinct()
                .map(p -> {
                    ProductResponse.ProductSearchRespDTO productDTO = new ProductResponse.ProductSearchRespDTO(p);
                    List<ProductResponse.ProductSearchRespDTO.ProductPicDTO> productPicDTOs = p.getProductPics()
                            .isEmpty()
                                    ? null
                                    : p.getProductPics().stream()
                                            .limit(1)
                                            .map(pp -> new ProductResponse.ProductSearchRespDTO.ProductPicDTO(pp))
                                            .collect(Collectors.toList());
                    productDTO.setProductPics((productPicDTOs));
                    return productDTO;
                })
                .collect(Collectors.toList());

        return responseDTO;
    }

    // 상품북마크
    public ProductResponse.ProductBookMarkRespDTO bookmarkProducts(
            ProductRequest.ProductBookMarkReqDTO productBookMarkReqDTO) {
        System.out.println("DTO 서비스 : " + productBookMarkReqDTO);

        ProductBookmark productBookMark = productBookMarkJPARepository.save(productBookMarkReqDTO.toEntity());
        return new ProductResponse.ProductBookMarkRespDTO(productBookMark);
    }

    // 상품북마크삭제
    @Transactional
    public ProductResponse.DeleteBookmarkRespDTO DeleteBookmarkProducts(Integer id) {

        productBookMarkJPARepository.deleteById(id);
        return null;
    }
}
