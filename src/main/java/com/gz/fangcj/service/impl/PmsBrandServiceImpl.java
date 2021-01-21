package com.gz.fangcj.service.impl;

import com.gz.fangcj.dto.PageDTO;
import com.gz.fangcj.entity.PmsBrand;
import com.gz.fangcj.entity.PmsBrandExample;
import com.gz.fangcj.mapper.PmsBrandMapper;
import com.gz.fangcj.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Fang chenjiang
 * @Date 2020/12/31
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageDTO<List<PmsBrand>> listBrand(int currentPage, int pageSize) {

        Integer begin = PageDTO.countBegin(pageSize, currentPage);
        List<PmsBrand>brandList=brandMapper.selectBrandPage(begin,pageSize);
        Long total=brandMapper.totalCount();
        return new PageDTO(currentPage,total,pageSize,brandList);
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
