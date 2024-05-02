package au.org.consumerdatastandards.holder.service;

import au.org.consumerdatastandards.holder.model.DiscoveryOutage;
import au.org.consumerdatastandards.holder.repository.DiscoveryOutageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DiscoveryOutageService {

    private final static Logger LOGGER = LoggerFactory.getLogger(DiscoveryOutageService.class);

    private final DiscoveryOutageRepository discoveryOutageRepository;

    @Autowired
    public DiscoveryOutageService(DiscoveryOutageRepository discoveryOutageRepository) {
        this.discoveryOutageRepository = discoveryOutageRepository;
    }

    public Iterable<DiscoveryOutage> getOutages() {
        LOGGER.debug("Retrieving outages");
        return discoveryOutageRepository.findAll(Sort.by(Sort.Order.asc("outageTime")));
    }
}
