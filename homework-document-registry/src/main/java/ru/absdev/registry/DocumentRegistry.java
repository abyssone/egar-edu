package ru.absdev.registry;

import ru.absdev.document.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiConsumer;

public class DocumentRegistry {
    private Map<Long, RegistryEntry> registry;
    private final Map<DocConst, BiConsumer<Document, RegistryEntry>> handlers;
    private static LongAdder id = new LongAdder();

    public DocumentRegistry() {
        registry = new HashMap<>();

        handlers = new HashMap<>() {{
           put(DocConst.PASSPORT, DocumentRegistry.this::addPassport);
           put(DocConst.BIRTH_CERT, DocumentRegistry.this::addBirthCert);
           put(DocConst.DRIVER_LICENSE, DocumentRegistry.this::addDriverLicense);
           put(DocConst.MILITARY_ID, DocumentRegistry.this::addMilitaryID);
        }};
    }


    /**
     *  В самом документе хранится только его код (int). Чтобы соотнести код документа с handler'ом,
     * добавляющим соответствующий тип документа в реестр, необходимо получить DocConst по коду.
     * @param d abstract class
     */
    public void addDocument(Document d) {
        Optional<DocConst> docConst = DocConst.findByCode(d.getDocCode());
        if (docConst.isEmpty()) throw new IllegalArgumentException("Код документа не соответствует ни одному DocConst");

        RegistryEntry entry = new RegistryEntry(
                d.getDocCode(),
                docConst.get().getName(),
                d.getStatus(),
                d.getOwnerName());

        // Инициализация записи происходит до ее добавления в registry во избежание добавления пустой записи при
        // возникновении ошибки на этапе инициализации.

        try {
        handlers.get(docConst.get()).accept(d, entry);
        } catch (NullPointerException e) {
            System.out.printf("Не найден обработчик для const: %d", docConst.get());
        }
        this.registry.put(getId(), entry);
    }

    private Long getId() {
        id.increment();
        return id.longValue();
    }

    private void addPassport(Document passportDoc, RegistryEntry entry) {
        Passport passport = (Passport) passportDoc;
        entry.setCitizenship(passport.getCitizenship());
        entry.setPassportSeriesAndNumber(passport.getSeriesAndNumber());
    }

    private void addBirthCert(Document birthCertDoc, RegistryEntry entry) {
        BirthCert birthCert = (BirthCert) birthCertDoc;
        entry.setBirthDate(birthCert.getBirthDate());
    }

    private void addDriverLicense(Document driverLicenseDoc, RegistryEntry entry) {
        DriverLicense driverLicense = (DriverLicense) driverLicenseDoc;
        entry.setDrivingCategories(driverLicense.getCategories());
        entry.setDriverLicenseIssueDate(driverLicense.getIssueDate());
        entry.setDriverLicenseExpirationDate(driverLicense.getExpirationDate());
    }

    private void addMilitaryID(Document MilitaryIDDoc, RegistryEntry entry) {
        MilitaryID militaryID = (MilitaryID) MilitaryIDDoc;
        entry.setNameOfMilitaryUnit(militaryID.getNameOfMilitaryUnit());
        entry.setMilitaryIDIssueDate(militaryID.getIssueDate());
    }

    public boolean deleteDocumentById(Long id) {
        if (!registry.containsKey(id)) return false;
        registry.remove(id);
        return true;
    }

    public Optional<RegistryEntry> getDocumentById(Long id) {
        if (!registry.containsKey(id)) return Optional.empty();
        return Optional.of(registry.get(id));
    }

    public Optional<RegistryEntry> getLastDocument() {
        if (id.longValue() == 0) return Optional.empty();
        Optional<RegistryEntry> entry = Optional.empty();

        for (Long i = id.longValue(); i > 0; i--) {
            entry = getDocumentById(i);
            if (entry.isPresent()) break;
        }
        return entry;
    }

    public Map<Long, RegistryEntry> getRegistry() {
        return registry;
    }
}
