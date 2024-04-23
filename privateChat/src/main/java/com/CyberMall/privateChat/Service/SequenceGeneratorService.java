package com.CyberMall.privateChat.Service;

import com.CyberMall.privateChat.Model.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public int generateSequence(String seqName) {
        Sequence counter = mongoOperations.findAndModify(
                Query.query(Criteria.where("_id").is(seqName)),
                new Update().inc("seq", 1),
                Sequence.class
        );
        if (counter == null) {
            counter = new Sequence();
            counter.setId(seqName);
            counter.setSeq(1);
            mongoOperations.save(counter);
        }
        return counter.getSeq();
    }
}