package com.gz.fangcj.service;

import com.gz.fangcj.dto.PageDTO;
import com.gz.fangcj.entity.PmsBrand;

import java.util.List;

/**
 * @Author Fang chenjiang
 * @Date 2020/12/31
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    PageDTO<List<PmsBrand>> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
